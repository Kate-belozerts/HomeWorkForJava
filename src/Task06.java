/*1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса,
используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: String str = "{'name':'Ivanov', 'country':'Russia', 'city':'Moscow', 'age':'null'}";
Результат "select * from students where “name” = “Ivanov” and “country”=”Russia” …
 */
public class Task06 {
    static public void main(String[] args) {
        StringBuilder select = new StringBuilder("select * from students where ");
        StringBuilder base = new StringBuilder("{'name':'Ivanov', 'country':'Russia', 'city':'null', 'age':'23'}");
        for (int i = 0; i < base.length(); i++) {
            if (base.charAt(i) == ':'){
                base.setCharAt(i, '=');
            }
        }
        String[] arr = base.toString().split(",");

        arr[0] = arr[0].replace("{", "");
        arr[arr.length-1] = arr[arr.length-1].replace("}", "");

        StringBuilder res = new StringBuilder(select);

        for (String s : arr) {
            if (s.contains("null")) continue;
            else res.append(s);
        }
        System.out.println(res);
    }
}
