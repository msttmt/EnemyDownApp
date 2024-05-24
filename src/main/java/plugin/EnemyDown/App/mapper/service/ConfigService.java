package plugin.EnemyDown.App.mapper.service;

import java.io.ObjectInputFilter.Config;
import java.util.List;
import org.springframework.stereotype.Service;
import plugin.EnemyDown.App.DuplicateConfigException;
import plugin.EnemyDown.App.mapper.GameConfigMapper;
import plugin.EnemyDown.App.mapper.data.GameConfig;
import plugin.EnemyDown.App.mapper.data.SpawnEnemy;


@Service
public class ConfigService {

  public final GameConfigMapper mapper;

  public ConfigService(GameConfigMapper mapper) {
    this.mapper = mapper;
  }

  public List<GameConfig> searchConfigList() {
    return mapper.selectConfigList();
  }
    public GameConfig searchConfig(String difficulty) {
      return mapper.selectConfig(difficulty);
  }
  public List<SpawnEnemy> searchSpawnEnemyList(String difficulty) {
    return mapper.selectSpawnEnemyList(difficulty);
  }

  public GameConfig registerConfig(GameConfig config) throws Exception{
    GameConfig existsConfig =searchConfig(config.getDifficulty());
    if (existsConfig != null){
      throw new DuplicateConfigException("Duplicate Config Error!");
    }
    mapper.insertConfig(config);
    return mapper.selectConfig(config.getDifficulty());
  }

  public List<SpawnEnemy> updateEnemyScore(SpawnEnemy enemy){
    mapper.updateEnemyScore(enemy);
    return mapper.selectSpawnEnemyList(enemy.getDifficulty());
  }
}

