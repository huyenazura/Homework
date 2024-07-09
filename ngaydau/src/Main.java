public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        GenerricCLass<Integer> obj1=new GenerricCLass<>(10);
        GenerricCLass<String> obj2=new GenerricCLass<>("abc");
        Integer number = obj1.get();
        String string=obj2.get();
        System.out.println(obj1.set(20));
        System.out.println((obj2.set("def")));
    }
}
class GenerricCLass<T>{
    private T t;
    public  GenerricCLass(T t){
        this.t=t;
    }
    public T get(){
        return t;
    }
    public T set (T t){
        this.t =t;
        return this.t;
    }

}