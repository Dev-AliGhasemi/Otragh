package ir.otragh.core.domain.framework;

import ir.otragh.core.domain.framework.errors.Error;
import lombok.Getter;

@Getter
public class Result {
    private boolean isSuccess;
    private boolean isFailure;
    private Error error;

    Result(boolean isSuccess, Error error) {
        if (isSuccess && error == Error.NONE)
            throw new IllegalStateException();
        if (!isSuccess && error == Error.NONE)
            throw new IllegalStateException();
        this.isSuccess = isSuccess;
        this.error = error;
    }

    public static Result success(){
        return new Result(true,Error.NONE);
    }

    public static Result failure(Error error){
        return new Result(false,error);
    }

    public static<T> DataResult<T> success(T data){
        return new DataResult<T>(data,true,Error.NONE);
    }

    @Getter
    public static class DataResult<T> extends Result{
        private T data;

        private DataResult(T data,boolean isSuccess, Error error) {
            super(isSuccess,error);
            this.data = data;
        }
    }


}

