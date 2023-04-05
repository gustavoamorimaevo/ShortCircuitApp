package com.example.a520.short_circuit;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by A520 on 01/07/2017.
 */
public class ManageFile {
    private static final String TAG = "ManageFile";
    private Context context;

    public ManageFile(Context context){
        this.context = context;
    }

    /**
     * Escreve no arquivo texto.
     * @param text Texto a ser escrito.
     * @return True se o texto foi escrito com sucesso.
     */
    public boolean WriteFile(String text){
        try {
            // Abre o arquivo para escrita ou cria se não existir
            FileOutputStream out = context.openFileOutput("conf2.txt",
                    Context.BIND_AUTO_CREATE);
            out.write(text.getBytes());
            out.write("\n".getBytes());
            out.flush();
            out.close();
            return true;

        } catch (Exception e) {
            Log.e(TAG, e.toString());
            return false;
        }
    }

    /**
     * Faz a leitura do arquivo
     * @return O texto lido.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public String ReadFile() throws FileNotFoundException, IOException {
        File file = context.getFilesDir();
        File textfile = new File(file + "/conf2.txt");

        FileInputStream input = context.openFileInput("conf2.txt");
        byte[] buffer = new byte[(int)textfile.length()];

        input.read(buffer);

        return new String(buffer);
    }
}
