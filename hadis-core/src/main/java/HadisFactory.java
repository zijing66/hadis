import java.util.Properties;

/**
 * 描述: [功能描述]
 *
 * @author YAOZJ
 * @version v1.0
 * @date 2024/11/12 15:05
 */
public class HadisFactory {

    public HadisClient buildClient(Properties clientProperties) {

        return new HadisClient();
    }

}
