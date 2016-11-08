package br.com.marcellogalhardo.challenge.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/**
 * Created by marcellogalhardo on 17/10/16.
 */

public class User implements Parcelable {

  public int id;
  public String login;
  public String type;
  @SerializedName("avatar_url") public String avatarUrl;

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.id);
    dest.writeString(this.login);
    dest.writeString(this.type);
    dest.writeString(this.avatarUrl);
  }

  public User() {
  }

  protected User(Parcel in) {
    this.id = in.readInt();
    this.login = in.readString();
    this.type = in.readString();
    this.avatarUrl = in.readString();
  }

  public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
    @Override public User createFromParcel(Parcel source) {
      return new User(source);
    }

    @Override public User[] newArray(int size) {
      return new User[size];
    }
  };
}
