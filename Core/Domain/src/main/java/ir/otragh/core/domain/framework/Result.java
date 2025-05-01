package ir.otragh.core.domain.framework;

import ir.otragh.core.domain.framework.errors.Error;
import lombok.Getter;

@Getter
public class Result {
    private boolean isSuccess;
    private Error error;

    protected Result(boolean isSuccess, Error error) {
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

    public static<T> ir.otragh.core.domain.framework.data.Result<T> success(T data){
        return new ir.otragh.core.domain.framework.data.Result<T>(data,true,Error.NONE);
    }
}

