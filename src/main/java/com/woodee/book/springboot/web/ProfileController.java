package com.woodee.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/*
    생성자 자동생성
    - 예전에도 정리를 했지만 완벽하게 이해하기 위해 다시 정리!
    - lombok 라이브러리를 이용해 3가지 방식으로 생성자 자동생성을 할 수 있다.
        1. @NoArgsConstructor : 인자값이 없는 생성자, 즉 파라미터가 없는
           기본 생성자를 만드는 어노테이션이다.
        2. @AllArgsConstructor : 모든 인자값을 갖는 생성자, 즉 모든 필드값을
           파라미터로 받아 생성자를 만드는 어노테이션이다.
        3. @RequiredArgsConstructor : 요구된 인자값을 갖는 생성자, 즉
           final 이나 @NonNull 인 필드값만 파라미터로 받아 생성자를 만드는
           어노테이션이다.
        * argument(인자) : 호출할 때 필요한 값을 인자라고 한다
          parameter(매개변수) : 인자값을 받는 변수를 매개변수, 파라미터라고 한다.
*/
@RequiredArgsConstructor
@RestController
public class ProfileController {
    /*
        Environment 객체?
        - Context 가 생성되면 Environment 객체를 얻어올 수 있다
        - 근데 왜 사용하지?
            - getActiveProfiles() 메소드를 이용해 현재 실행 중인
              ActiveProfile 을 가져오기 위해 사용한다.
    */
    private final Environment env;


    @GetMapping("/profile")
    public String profile() {
        /*
            Arrays 클래스
            - 배열을 다루기 위한 여러가지 메소드가 포함되어 있다.
            - Arrays 클래스의 모든 메소드는 static 이므로
              객체를 생성하지 않아도 바로 사용할 수 있다.
            Arrays 클래스의 asList() 메소드
            - 배열을 리스트로 반환해준다
                return new Arrays.ArrayList(a)
            - 제약사항
                - 고정된 사이즈를 반환하기 때문에 요소를 추가, 삭제는
                  불가능하다.
        */
        List<String> profiles = Arrays.asList(env.getActiveProfiles());
        List<String> realProfiles = Arrays.asList("real", "real1", "real2");
        String defaultProfile = profiles.isEmpty() ? "default" : profiles.get(0);
        /*
        stream 찾아보자.
        */
        return profiles.stream()
                .filter(realProfiles::contains)
                .findAny()
                .orElse(defaultProfile);
    }
}
