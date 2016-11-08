package br.com.marcellogalhardo.challenge.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/**
 * Created by marcellogalhardo on 17/10/16.
 */

public class Repository implements Parcelable {

  public static final String KEY = "Model.Repository";

  public int id;
  public String name;
  public String description;
  public String forks;
  public User owner;
  @SerializedName("open_issues") public String openIssues;
  @SerializedName("open_issues_count") public String openIssuesCount;
  @SerializedName("stargazers_count") public String stars;

  public Repository() {
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.id);
    dest.writeString(this.name);
    dest.writeString(this.description);
    dest.writeString(this.forks);
    dest.writeParcelable(this.owner, flags);
    dest.writeString(this.openIssues);
    dest.writeString(this.openIssuesCount);
    dest.writeString(this.stars);
  }

  protected Repository(Parcel in) {
    this.id = in.readInt();
    this.name = in.readString();
    this.description = in.readString();
    this.forks = in.readString();
    this.owner = in.readParcelable(User.class.getClassLoader());
    this.openIssues = in.readString();
    this.openIssuesCount = in.readString();
    this.stars = in.readString();
  }

  public static final Creator<Repository> CREATOR = new Creator<Repository>() {
    @Override public Repository createFromParcel(Parcel source) {
      return new Repository(source);
    }

    @Override public Repository[] newArray(int size) {
      return new Repository[size];
    }
  };
}
