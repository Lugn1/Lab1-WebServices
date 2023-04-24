import org.example.service.Service;

public class Consumer {
    public static void main(String[] args) {
        Service backend = new Service();
        System.out.println(backend.getBackendService());
    }
}
