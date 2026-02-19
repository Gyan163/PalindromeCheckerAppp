public class UseCase2PalindromeCheckerApp{
    public static void main(String[] args) {
        String text = "madam";
        boolean isPalindrome = true;

        for (int i = 0; i < text.length()/2;i++) {
            if(text.charAt(i)!=text.charAt(text.length()-1-i)) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("input text:"+text);
        System.out.println("is it Palindrome? :" + isPalindrome);
    }
}

