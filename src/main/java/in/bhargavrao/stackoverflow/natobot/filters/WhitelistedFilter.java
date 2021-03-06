package in.bhargavrao.stackoverflow.natobot.filters;


import in.bhargavrao.stackoverflow.natobot.entities.NatoPost;
import in.bhargavrao.stackoverflow.natobot.utils.CheckUtils;

/**
 * Created by bhargav.h on 01-Oct-16.
 */
public class WhitelistedFilter implements Filter {
    private NatoPost post;
    private double value;
    private String listedWord;

    public WhitelistedFilter(NatoPost post) {
        this.post = post;
        value = -1;
        listedWord = null;
    }

    @Override
    public boolean filter() {
        String listedWord = CheckUtils.checkForWhiteListedWords(post);
        if(listedWord!=null){
            this.listedWord = listedWord;
            return true;
        }
        return false;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public String description() {
        return "Contains Whitelisted Word - "+listedWord;
    }
}
