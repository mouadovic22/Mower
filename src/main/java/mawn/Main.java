package mawn;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        URL resourceUrl = Main.class.getClassLoader().getResource("input.txt");
        String path = URLDecoder.decode(String.valueOf(resourceUrl.getPath()), "UTF-8");
        try (
                BufferedReader br = new BufferedReader(new FileReader(path))
        ) {
            String[] size = br.readLine().split(" ");
            int xMax = Integer.parseInt(size[0]);
            int yMax = Integer.parseInt(size[1]);
            Lawn lawn = new Lawn(xMax, yMax);

            String line;
            while ((line = br.readLine()) != null) {
                String[] position = line.split(" ");
                int x = Integer.parseInt(position[0]);
                int y = Integer.parseInt(position[1]);
                char orientation = position[2].charAt(0);

                Mower mower = new Mower(x, y, orientation, lawn);
                String movements = br.readLine();
                for (int i = 0; i < movements.length(); i++) {
                    mower.move(movements.charAt(i));
                }
                System.out.println(mower);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
