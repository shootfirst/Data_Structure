class Solution {
    public boolean isLongPressedName(String name, String typed) {
        char pre = 0;
        int name_ptr = 0, typed_ptr = 0,
                name_leng = name.length(), typed_leng = typed.length();

        while (name_ptr < name_leng && typed_ptr < typed_leng) {
            if (name.charAt(name_ptr) == typed.charAt(typed_ptr)) {
                pre = name.charAt(name_ptr);
                name_ptr++;
                typed_ptr++;
            } else if(typed.charAt(typed_ptr) == pre) {
                typed_ptr++;
            } else {
                return false;
            }
        }

        // 注意后处理！！！
        if (name_ptr == name_leng && typed_ptr == typed_leng) {
            return true;
        } else if (name_ptr == name_leng && typed_ptr < typed_leng) {
            while (typed_ptr < typed_leng && typed.charAt(typed_ptr) == pre) {
                typed_ptr++;
            }
            if (name_ptr == name_leng && typed_ptr == typed_leng) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }


    }
}