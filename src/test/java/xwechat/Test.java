package xwechat;

import java.util.List;

import net.xprogrammer.xwechat.dto.Person;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Test {

	public static void main(String[] args) {
		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.0.3:8080/xwechat/").addConverterFactory(GsonConverterFactory.create()).build();

		TestService service = retrofit.create(TestService.class);
		Call<List<Person>> persons = service.listPersons();
		persons.enqueue(new Callback<List<Person>>() {
			@Override
			public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
				List<Person> list = response.body();
				for(Person p: list){
					System.out.println(p.getName() + p.getAge());
				}
			}

			@Override
			public void onFailure(Call<List<Person>> call, Throwable t) {

			}
		});
	}

}
