package com.debin.retrofitmvp.presenter;

import com.debin.retrofitmvp.contract.MainContract;
import com.debin.retrofitmvp.model.Cake;

import java.util.ArrayList;

public class MainPresenterImpl implements MainContract.Presenter, MainContract.GetCakeIntractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetCakeIntractor getCakeIntractor;

    public MainPresenterImpl(MainContract.MainView mainView, MainContract.GetCakeIntractor getCakeIntractor) {
        this.mainView = mainView;
        this.getCakeIntractor = getCakeIntractor;
    }

    @Override
    public void onRequestDataFromServer() {
        if(mainView!=null) {
            mainView.showProgress();
        }

     getCakeIntractor.getCakeArrayList(this);
    }

    @Override
    public void onDestroy() {
     mainView = null;
    }


    @Override
    public void onFinished(ArrayList<Cake> cakeArrayList) {
       if(mainView!=null) {
           mainView.setDataToRecyclerView(cakeArrayList);
           mainView.hideProgress();
       }
    }

    @Override
    public void onFailure(Throwable t) {
      if(mainView!=null) {
          mainView.onResponseFailure(t);
          mainView.hideProgress();
      }
    }
}
