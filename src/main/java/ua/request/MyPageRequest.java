package ua.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
public class MyPageRequest {

    @Getter@Setter private int numberPage;

    @Getter@Setter private int sizePAge;
}
