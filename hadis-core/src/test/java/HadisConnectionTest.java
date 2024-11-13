import com.hadis.core.HadisFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * 描述: [功能描述]
 *
 * @author YAOZJ
 * @version v1.0
 * @date 2024/11/12 16:56
 */
public class HadisConnectionTest {

    private Properties redisProperties;

    @Before
    public void before() {
        redisProperties = new Properties();
        try {
            redisProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hadis.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void connectTest() {
        final HadisFactory hadisFactory = new HadisFactory();
        hadisFactory.buildClient(redisProperties);
    }

}
