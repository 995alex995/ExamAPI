package anesic;

public interface ApiResult<T> {
    void onSuccess(T result);
    void onError(Exception e);
}


