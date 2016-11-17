package xwechat;

import java.util.List;

import net.xprogrammer.xwechat.dto.Person;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TestService {
    @GET("android/test/person")
    Call<List<Person>> listPersons();
}
