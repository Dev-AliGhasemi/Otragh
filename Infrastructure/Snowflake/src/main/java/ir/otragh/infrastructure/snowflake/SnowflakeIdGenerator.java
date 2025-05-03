package ir.otragh.infrastructure.snowflake;

import com.github.wujun234.uid.impl.DefaultUidGenerator;
import com.github.wujun234.uid.impl.UidProperties;
import ir.otragh.applicationservice.contracts.IdGenerator;
import org.springframework.stereotype.Component;

@Component
public class SnowflakeIdGenerator implements IdGenerator {
    @Override
    public Long generateId() {
        return new DefaultUidGenerator(new UidProperties()).getUID();
    }
}
