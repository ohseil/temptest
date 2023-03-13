package project.CItestProject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestController.class)
public class controllerTest {

    @Autowired
    MockMvc mockMvc;

    @Value("${github.api.client-id}")
    private String githubClientId;
    @Value("${github.api.client-secrets}")
    private String githubClientSecrets;
    @Value("${jwt.access-token.secret-key}")
    private String accessTokenKey;
    @Value("${jwt.refresh-token.secret-key}")
    private String refreshTokenKey;
    @Value("${jwt.access-token.valid-time}")
    private Long accessTokenValidTime;
    @Value("${jwt.refresh-token.valid-time}")
    private Long refreshTokenValidTime;

    @Value("${kakao.api.key}")
    private String kakaoApiKey;

    @Test
    public void 테스트() throws Exception {
        //System.out.println(githubClientId + githubClientSecrets + accessTokenKey + refreshTokenKey + accessTokenValidTime + refreshTokenValidTime);
        final MvcResult mvcResult = mockMvc.perform(
                        get("/func")
                                .contentType(MediaType.APPLICATION_JSON)
                                .characterEncoding("UTF-8")
                )
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        assertThat(mvcResult.getResponse().getContentAsString()).isEqualTo("hello");
        assertThat(kakaoApiKey).isEqualTo("hello");
        assertThat(refreshTokenKey).isEqualTo("abcd");
    }

}
