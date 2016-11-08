package br.com.marcellogalhardo.challenge.ui.repositorylist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.marcellogalhardo.challenge.R;
import br.com.marcellogalhardo.challenge.model.Repository;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

public class RepositoryListAdapter extends RecyclerView.Adapter<RepositoryListAdapter.ViewHolder> {

  private Context context;
  private OnClickListener onClickListener;
  private List<Repository> repositories = new ArrayList<>();

  public void add(List<Repository> repositories) {
    this.repositories.addAll(repositories);
    notifyDataSetChanged();
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    context = parent.getContext();
    View view = LayoutInflater.from(context).inflate(R.layout.item_repository_list, parent, false);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    final Repository repository = repositories.get(position);
    holder.repositoryName.setText(repository.name);
    holder.repositoryDescription.setText(repository.description);
    holder.repositoryCodeForks.setText(repository.forks);
    holder.repositoryStars.setText(repository.stars);
    holder.userName.setText(repository.owner.login);
    holder.realName.setText(repository.owner.type);
    Glide.with(context)
        .load(repository.owner.avatarUrl)
        .centerCrop()
        .placeholder(R.drawable.image_user)
        .crossFade()
        .into(holder.userImage);
    holder.container.setOnClickListener(v -> onClickListener.onClick(repository));
  }

  @Override public int getItemCount() {
    if (repositories != null) {
      return repositories.size();
    }
    return 0;
  }

  public void setOnClickListener(OnClickListener onClickListener) {
    this.onClickListener = onClickListener;
  }

  static class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.container) View container;
    @BindView(R.id.repository_name) TextView repositoryName;
    @BindView(R.id.repository_description) TextView repositoryDescription;
    @BindView(R.id.repository_code_forks) TextView repositoryCodeForks;
    @BindView(R.id.repository_stars) TextView repositoryStars;
    @BindView(R.id.user_image) ImageView userImage;
    @BindView(R.id.user_name) TextView userName;
    @BindView(R.id.user_real_name) TextView realName;

    ViewHolder(View view) {
      super(view);
      ButterKnife.bind(this, view);
    }
  }

  public interface OnClickListener {
    void onClick(Repository repository);
  }
}
