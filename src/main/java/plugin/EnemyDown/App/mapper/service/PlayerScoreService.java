package plugin.EnemyDown.App.mapper.service;

import java.util.List;
import org.springframework.stereotype.Service;

import plugin.EnemyDown.App.mapper.PlayerScoreMapper;

import plugin.EnemyDown.App.mapper.data.PlayerScore;

@Service
public class PlayerScoreService {
  public final PlayerScoreMapper mapper;

  public PlayerScoreService(PlayerScoreMapper mapper) {
    this.mapper = mapper;
  }
  public List<PlayerScore> searchPlayerScoreList() {
    return mapper.selectPlayerScoreList();
  }

}
