package hello.core.lifecycle;

public class LifecycleBean {
    private final LifeCycleDependencyBean lifeCycleDependencyBean;

    public LifecycleBean(LifeCycleDependencyBean lifeCycleDependencyBean) {
        this.lifeCycleDependencyBean = lifeCycleDependencyBean;
        System.out.println("빈 생성");
    }

    public void init() {
        System.out.println("초기화");
    }
    public void close() {
        disconnect();
        System.out.println("소멸");
    }

    private void disconnect() {
        System.out.println("disconnect");
    }
}
