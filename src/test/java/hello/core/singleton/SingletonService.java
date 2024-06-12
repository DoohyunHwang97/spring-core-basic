package hello.core.singleton;

public class SingletonService implements Service {
    private static final SingletonService instance = new SingletonService();

    private SingletonService() {
    }

    public static SingletonService getInstance() {
        return instance;
    }

    @Override
    public void serve() {
        System.out.println("저는 싱글톤 서비스입니다.");
    }
}
