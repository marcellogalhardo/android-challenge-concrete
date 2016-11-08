package br.com.marcellogalhardo.challenge.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by marcellogalhardo on 17/10/16.
 */

public class RepositoryList implements Parcelable {

  @SerializedName("total_count") public int totalCount;
  @SerializedName("incomplete_results") public boolean incompleteResults;
  public List<Repository> items;

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeInt(this.totalCount);
    dest.writeByte(this.incompleteResults ? (byte) 1 : (byte) 0);
    dest.writeTypedList(this.items);
  }

  public RepositoryList() {
  }

  protected RepositoryList(Parcel in) {
    this.totalCount = in.readInt();
    this.incompleteResults = in.readByte() != 0;
    this.items = in.createTypedArrayList(Repository.CREATOR);
  }

  public static final Parcelable.Creator<RepositoryList> CREATOR =
      new Parcelable.Creator<RepositoryList>() {
        @Override public RepositoryList createFromParcel(Parcel source) {
          return new RepositoryList(source);
        }

        @Override public RepositoryList[] newArray(int size) {
          return new RepositoryList[size];
        }
      };
}
