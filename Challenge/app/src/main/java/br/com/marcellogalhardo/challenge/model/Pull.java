package br.com.marcellogalhardo.challenge.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class Pull implements Parcelable {

  public int id;
  public String title;
  public String body;
  public String state;
  @SerializedName("created_at") public Date createdAt;
  @SerializedName("html_url") public String url;
  public User user;

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.id);
    dest.writeString(this.title);
    dest.writeString(this.body);
    dest.writeString(this.state);
    dest.writeLong(this.createdAt != null ? this.createdAt.getTime() : -1);
    dest.writeString(this.url);
    dest.writeParcelable(this.user, flags);
  }

  public Pull() {
  }

  protected Pull(Parcel in) {
    this.id = in.readInt();
    this.title = in.readString();
    this.body = in.readString();
    this.state = in.readString();
    long tmpCreatedAt = in.readLong();
    this.createdAt = tmpCreatedAt == -1 ? null : new Date(tmpCreatedAt);
    this.url = in.readString();
    this.user = in.readParcelable(User.class.getClassLoader());
  }

  public static final Parcelable.Creator<Pull> CREATOR = new Parcelable.Creator<Pull>() {
    @Override public Pull createFromParcel(Parcel source) {
      return new Pull(source);
    }

    @Override public Pull[] newArray(int size) {
      return new Pull[size];
    }
  };
}
