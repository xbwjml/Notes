package 枚举;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
@AllArgsConstructor
public enum Column {

    TEL("电话","phone", true ){
        protected boolean validate(String value) {

            //先校验必填项
            if ( !checkEssential(value) )
                return false;

            //校验正则...
            return true;
        }
    };

    private final String name;

    private final String cName;

    private final boolean essential;

    protected abstract boolean validate(String value);

    protected boolean checkEssential(String value){
        if ( isEssential() && StringUtils.isEmpty(value) )
            return false;
        return true;
    }
}
