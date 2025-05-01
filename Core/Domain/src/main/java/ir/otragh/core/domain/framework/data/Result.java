package ir.otragh.core.domain.framework.data;

import ir.otragh.core.domain.framework.errors.Error;
import lombok.Getter;

@Getter
public class Result<T> extends ir.otragh.core.domain.framework.Result {
    private T data;

    public Result(T data, boolean isSuccess, Error error) {
        super(isSuccess,error);
        this.data = data;
    }
}
