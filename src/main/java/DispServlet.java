import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/app2/disp")
public class DispServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/PrefecturesServlet.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 文字エンコーディングを設定
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        List<String> name_list = new ArrayList<String>();
        name_list.add("北海道");
        name_list.add("青森");
        name_list.add("岩手");
        name_list.add("宮城");
        name_list.add("秋田");
        name_list.add("山形");
        name_list.add("福島");
        name_list.add("茨城");
        name_list.add("栃木");
        name_list.add("群馬");
        name_list.add("埼玉");
        name_list.add("千葉");
        name_list.add("東京");
        name_list.add("神奈川");
        name_list.add("新潟");
        name_list.add("富山");
        name_list.add("石川");
        name_list.add("福井");
        name_list.add("山梨");
        name_list.add("長野");
        name_list.add("岐阜");
        name_list.add("静岡");
        name_list.add("愛知");
        name_list.add("三重");
        name_list.add("滋賀");
        name_list.add("京都");
        name_list.add("大阪");
        name_list.add("兵庫");
        name_list.add("奈良");
        name_list.add("和歌山");
        name_list.add("鳥取");
        name_list.add("島根");
        name_list.add("岡山");
        name_list.add("広島");
        name_list.add("山口");
        name_list.add("徳島");
        name_list.add("香川");
        name_list.add("愛媛");
        name_list.add("高知");
        name_list.add("福岡");
        name_list.add("佐賀");
        name_list.add("長崎");
        name_list.add("熊本");
        name_list.add("大分");
        name_list.add("宮崎");
        name_list.add("鹿児島");
        name_list.add("沖縄");
        
        String numStr = request.getParameter("prefectures_num"); // JSPから受け取り
        int pre_num = 0; // 初期値
        List<String> chosen_list = new ArrayList<String>();

        if (numStr == null || numStr.isEmpty()) {
            request.setAttribute("errorMessage", "ERROR");
        } else {
            try {
                pre_num = Integer.parseInt(numStr); // intに変換
                if (pre_num < 1 || pre_num > name_list.size()) {
                    request.setAttribute("errorMessage", "ERR");
                } else {
                    Random rand = new Random();
                    for (int i = 0; i < pre_num; i++){
                        int RandomIndex = rand.nextInt(name_list.size());
                        String ChosenPrefecture = name_list.get(RandomIndex);
                        chosen_list.add(ChosenPrefecture);
                        name_list.remove(RandomIndex);
                    }
                }
            } catch (NumberFormatException e) {
                request.setAttribute("errorMessage", "ERR");
            }
        }
        request.setAttribute("chosen_list", chosen_list);
        request.getRequestDispatcher("/disp.jsp").forward(request, response);
    }
}
