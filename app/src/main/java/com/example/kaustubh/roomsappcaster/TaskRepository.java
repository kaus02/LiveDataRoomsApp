package com.example.kaustubh.roomsappcaster;

import android.app.Application;
import androidx.lifecycle.LiveData;
import android.os.AsyncTask;

import java.lang.ref.WeakReference;
import java.util.List;

public class TaskRepository {

    private TaskDao taskDao;
    private LiveData<List<Task>> list;

    public TaskRepository(Application application) {
        RoomsDatabase database = RoomsDatabase.getInstance(application);
        taskDao = database.getTaskDao();
        list = taskDao.getTasks();
//        new RetrieveTask(this).execute();
    }

    public LiveData<List<Task>> getList() {
        return list;
    }

    public void insertTask(Task task){
        new InsertTask(this).execute(task);
    }

    private class InsertTask extends AsyncTask<Task,Void,Void> {

        WeakReference<TaskRepository> taskRepositoryWeakReference;

        public InsertTask(TaskRepository taskRepositoryWeakReference) {
            this.taskRepositoryWeakReference = new WeakReference<TaskRepository>(taskRepositoryWeakReference);
        }


        @Override
        protected Void doInBackground(Task... tasks) {

            taskRepositoryWeakReference.get().taskDao.InsertTask(tasks[0]);
            return null;
        }
    }

    private class RetrieveTask extends AsyncTask<Void,Void,LiveData<List<Task>>>{

        WeakReference<TaskRepository> repositoryWeakReference;

        public RetrieveTask(TaskRepository taskRepositoryWeakReference) {
            this.repositoryWeakReference = new WeakReference<TaskRepository>(taskRepositoryWeakReference);
        }

        @Override
        protected LiveData<List<Task>> doInBackground(Void... voids) {
            return repositoryWeakReference.get().taskDao.getTasks();
        }

        @Override
        protected void onPostExecute(LiveData<List<Task>> listLiveData) {
            list = listLiveData;
        }
    }
}
