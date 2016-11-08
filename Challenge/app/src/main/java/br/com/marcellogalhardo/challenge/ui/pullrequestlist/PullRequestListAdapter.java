package br.com.marcellogalhardo.challenge.ui.pullrequestlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.marcellogalhardo.challenge.R;
import br.com.marcellogalhardo.challenge.model.Pull;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

public class PullRequestListAdapter
    extends RecyclerView.Adapter<PullRequestListAdapter.ViewHolder> {

  private Context context;
  private PullRequestListAdapter.OnClickListener onClickListener;
  private List<Pull> pulls = new ArrayList<>();

  public void add(List<Pull> pulls) {
    this.pulls = pulls;
    notifyDataSetChanged();
  }

  @Override
  public PullRequestListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    context = parent.getContext();
    View view =
        LayoutInflater.from(context).inflate(R.layout.item_pull_request_list, parent, false);
    return new PullRequestListAdapter.ViewHolder(view);
  }

  @Override public void onBindViewHolder(PullRequestListAdapter.ViewHolder holder, int position) {
    final Pull pull = pulls.get(position);
    holder.pullRequestTitle.setText(pull.title);
    holder.pullRequestBody.setText(pull.body);
    holder.userName.setText(pull.user.login);
    holder.realName.setText(pull.user.type);
    Glide.with(context)
        .load(pull.user.avatarUrl)
        .centerCrop()
        .placeholder(R.drawable.image_user)
        .crossFade()
        .into(holder.userImage);
    holder.container.setOnClickListener(v -> onClickListener.onClick(pull));
  }

  @Override public int getItemCount() {
    if (pulls != null) {
      return pulls.size();
    }
    return 0;
  }

  public void setOnClickListener(PullRequestListAdapter.OnClickListener onClickListener) {
    this.onClickListener = onClickListener;
  }

  static class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.container) View container;
    @BindView(R.id.pull_request_title) TextView pullRequestTitle;
    @BindView(R.id.pull_request_body) TextView pullRequestBody;
    @BindView(R.id.user_image) ImageView userImage;
    @BindView(R.id.user_name) TextView userName;
    @BindView(R.id.user_real_name) TextView realName;

    ViewHolder(View view) {
      super(view);
      ButterKnife.bind(this, view);
    }
  }

  public interface OnClickListener {
    void onClick(Pull pull);
  }
}

