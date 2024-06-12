package hello.core.singleton;

public class NotSingletonService implements Service {
    public NotSingletonService() {
    }

    @Override
    public void serve() {
        System.out.println("저는 싱글톤 서비스가 아닙니다.");
    }
}
