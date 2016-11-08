package br.com.marcellogalhardo.challenge.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import br.com.marcellogalhardo.challenge.MainApplication;
import br.com.marcellogalhardo.challenge.dagger.component.ActivityComponent;
import br.com.marcellogalhardo.challenge.dagger.component.FragmentComponent;
import br.com.marcellogalhardo.challenge.dagger.component.MainComponent;

public class BaseFragment extends Fragment {

  private FragmentComponent fragmentComponent;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupFragmentComponent();
  }

  private void setupFragmentComponent() {
    fragmentComponent = getMainComponent().fragmentComponent();
  }

  protected BaseActivity getBaseActivity() {
    return (BaseActivity) getActivity();
  }

  protected MainApplication getMainApplication() {
    return getBaseActivity().getMainApplication();
  }

  protected MainComponent getMainComponent() {
    return getBaseActivity().getMainComponent();
  }

  protected ActivityComponent getActivityComponent() {
    return getBaseActivity().getActivityComponent();
  }

  protected FragmentComponent getFragmentComponent() {
    return fragmentComponent;
  }
}
