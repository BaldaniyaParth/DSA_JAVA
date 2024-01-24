package Week2;

public class SimplifyPath {

    public static void main(String[] args) {
        String path = "/home/";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String pathString) {
        String[] paths=pathString.split("/");
        StringBuilder result=new StringBuilder();

        for(String path:paths)
        {
            if(path.length()==0 || path.equals("."))
                continue;
            else if(path.equals(".."))
            {
                if(result.length()>0)
                {
                    int index=result.lastIndexOf("/");
                    result.delete(index,result.length());
                }
            }
            else
                result.append("/").append(path);
        }
        if(result.length()==0)
            result.append("/");

        return result.toString();
    }
}
