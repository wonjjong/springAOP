package hello.proxy.pureproxy.decorator.code;

/**
 * 내부에 호출 대상인 component 를 가지고 있어야
 * 한다. 그리고 component 를 항상 호출해야 한다. 이 부분이 중복이다
 */
public abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}
