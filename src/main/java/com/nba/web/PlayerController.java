package com.nba.web;

import java.util.List;
import java.util.Optional;
import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.nba.business.player.Player;
import com.nba.business.player.PlayerRepository;
import com.nba.business.team.Team;
import com.nba.util.NBAMaintenanceReturn;

@CrossOrigin
@Controller
@RequestMapping(path="/Players")
public class PlayerController extends BaseController {
	@Autowired
	private PlayerRepository playerRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable<Player> getAllPlayers() {
		return playerRepository.findAll();
	}
	
	@GetMapping(path="/Get")
	public @ResponseBody List<Player> getPlayer(@RequestParam int id) {
		Optional<Player> p = playerRepository.findById(id);
		return getReturnArray(p);
	}
	
	@PostMapping(path="/Add")
	public @ResponseBody NBAMaintenanceReturn addNewPlayer(@RequestBody Player player) {
		try {
			playerRepository.save(player);
			return NBAMaintenanceReturn.getMaintReturn(player);
		}
		catch (DataIntegrityViolationException dive) {
			return NBAMaintenanceReturn.getMaintReturnError(player, dive.getRootCause().toString());
		}
		catch (Exception e) {
			e.printStackTrace();
			return NBAMaintenanceReturn.getMaintReturnError(player, e.getMessage());
		}
	}
	
	@GetMapping(path="/Remove")
	public @ResponseBody NBAMaintenanceReturn deletePlayer(@RequestParam int id) {
		Optional<Player> player = playerRepository.findById(id);
		try {
			playerRepository.delete(player.get());
			return NBAMaintenanceReturn.getMaintReturn(player.get());
		}
		catch (DataIntegrityViolationException dive) {
			return NBAMaintenanceReturn.getMaintReturnError(player, dive.getRootCause().toString());
		}
		catch (Exception e) {
			return NBAMaintenanceReturn.getMaintReturnError(player, e.toString());
		}
	
	}
	
	@PostMapping(path="/Change")
	public @ResponseBody NBAMaintenanceReturn updatePlayer(@RequestBody Player player) {
		try {
			playerRepository.save(player);
			return NBAMaintenanceReturn.getMaintReturn(player);
		}
		catch (DataIntegrityViolationException dive) {
			return NBAMaintenanceReturn.getMaintReturnError(player, dive.getRootCause().toString());
		}
		catch (Exception e) {
			return NBAMaintenanceReturn.getMaintReturnError(player, e.toString());
		}
	}
	

}
