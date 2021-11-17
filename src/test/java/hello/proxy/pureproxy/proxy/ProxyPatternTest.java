package hello.proxy.pureproxy.proxy;


import hello.proxy.pureproxy.proxy.code.CacheProxy;
import hello.proxy.pureproxy.proxy.code.ProxyPatternClient;
import hello.proxy.pureproxy.proxy.code.RealSubject;
import hello.proxy.pureproxy.proxy.code.Subject;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    void noProxyTest() {
        RealSubject subject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(subject);
        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void cacheProxyTest() {

        Subject realSubject = new RealSubject();
        System.out.println(realSubject.getClass().getClassLoader());
        System.out.println(realSubject.getClass().getClassLoader().getParent());
        System.out.println(realSubject.getClass().getClassLoader().getParent().getParent());
        System.out.println("Thread.currentThread().getContextClassLoader() = " + Thread.currentThread().getContextClassLoader());
        Subject cacheProxy = new CacheProxy(realSubject);
        ProxyPatternClient client = new ProxyPatternClient(cacheProxy);
        client.execute();
        client.execute();
        client.execute();
    }
}
