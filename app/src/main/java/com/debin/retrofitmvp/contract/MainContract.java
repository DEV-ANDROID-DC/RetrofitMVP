package com.debin.retrofitmvp.contract;

import com.debin.retrofitmvp.model.Cake;

import java.util.ArrayList;

public interface MainContract {

    interface Presenter{
      void onRequestDataFromServer();
      void onDestroy();
    }

    interface MainView{
        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(ArrayList<Cake> cakeArrayList);

        void onResponseFailure(Throwable throwable);
    }

    //for fetching data from server
    interface GetCakeIntractor{

        interface OnFinishedListener {
            void onFinished(ArrayList<Cake> cakeArrayList);
            void onFailure(Throwable t);
        }

        void getCakeArrayList(OnFinishedListener onFinishedListener);

    }
}
