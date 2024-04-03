package ra.business.config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile
{
    public static final String PATH_CATEGORY = "/Users/hoanganh/QAhocJAVA/Practive/src/ra/business/data/Category.txt";
    public static final String PATH_PRODUCT = "/Users/hoanganh/QAhocJAVA/Practive/src/ra/business/data/Product.txt";
    public static <T> void writeObjectToFile (List<T> list, String path) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try
        {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        }catch (Exception e){
            e.getStackTrace();
        }finally
        {
            try
            {
                if (fos!=null){
                    fos.close();
                }
                if (oos!=null){
                    oos.close();
                }
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }


}

public static <T> List<T> readObjectFromFile(String path)
{
    FileInputStream fis = null;
    ObjectInputStream ois = null;
    List<T> list = new ArrayList<>();
    try
    {
        fis = new FileInputStream(path);
        ois = new ObjectInputStream(fis);
        while (true) {
            T object = (T) ois.readObject();
            list.add(object);
        }
//        list = (List<T>) ois.readObject();
    } catch (IOException | ClassNotFoundException e)
    {
        throw new RuntimeException(e);
    }
    catch (Exception e){
        e.getStackTrace();
    }
    finally
    {
        try
        {
            if (fis!=null){
                fis.close();
            }if (ois!=null){
                ois.close();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }catch (Exception e){
            e.getStackTrace();
        }
    }
    return list;
}
}
