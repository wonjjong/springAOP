package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TempDecorator extends Decorator {

    public TempDecorator(Component component) {
        super(component);
    }

    @Override
    public String operation() {
        log.info("TempDecorator 실행");

        String result = component.operation();

        log.info("TempDecorator 종료");

        return result;
    }
}
