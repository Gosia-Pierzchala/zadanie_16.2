package tekst;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/tekst")
public class PrzelicznikTekstuServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        final PrintWriter writer = response.getWriter();

        writer.println(text);

        writer.println("Ilość wszystkich znakow: " + text.length());

        String newText = text.replace(" ", "");
        writer.println("Ilość znaków bez spacji: " + newText.length());

        String[] znaki = text.split(" ");
        writer.println("Ilość wyrazów: " + znaki.length);

        writer.println("Czy tekst jest palindromem? " + checkIfpalindrom(text));
    }

    public static boolean checkIfpalindrom(String tekst){
        StringBuilder builder = new StringBuilder(tekst);
        String reversed = builder.reverse().toString();
        if(tekst.equals(reversed)){
            return true;
        }
        else
            return false;
    }

}
