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
import com.nba.business.team.Team;
import com.nba.business.team.TeamRepository;
import com.nba.util.NBAMaintenanceReturn;

@CrossOrigin
@Controller
@RequestMapping(path="/Teams")
public class TeamController extends BaseController {
	@Autowired
	private TeamRepository teamRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable<Team> getAllTeams() {
		return teamRepository.findAll();
	}
	
	@GetMapping(path="/Get")
	public @ResponseBody List<Team> getTeam(@RequestParam int id) {
		Optional<Team> t = teamRepository.findById(id);
		return getReturnArray(t);
	}
	
	@PostMapping(path="/Add")
	public @ResponseBody NBAMaintenanceReturn addNewTeam(@RequestBody Team team) {
		try {
			teamRepository.save(team);
			return NBAMaintenanceReturn.getMaintReturn(team);
		}
		catch (DataIntegrityViolationException dive) {
			return NBAMaintenanceReturn.getMaintReturnError(team, dive.getRootCause().toString());
		}
		catch (Exception e) {
			e.printStackTrace();
			return NBAMaintenanceReturn.getMaintReturnError(team, e.getMessage());
		}
	}
	
	@GetMapping(path="/Remove")
	public @ResponseBody NBAMaintenanceReturn deleteTeam(@RequestParam int id) {
		Optional<Team> team = teamRepository.findById(id);
		try {
			teamRepository.delete(team.get());
			return NBAMaintenanceReturn.getMaintReturn(team.get());
		}
		catch (DataIntegrityViolationException dive) {
			return NBAMaintenanceReturn.getMaintReturnError(team, dive.getRootCause().toString());
		}
		catch (Exception e) {
			return NBAMaintenanceReturn.getMaintReturnError(team, e.toString());
		}
	
	}
	
	@PostMapping(path="/Change")
	public @ResponseBody NBAMaintenanceReturn updateTeam(@RequestBody Team team) {
		try {
			teamRepository.save(team);
			return NBAMaintenanceReturn.getMaintReturn(team);
		}
		catch (DataIntegrityViolationException dive) {
			return NBAMaintenanceReturn.getMaintReturnError(team, dive.getRootCause().toString());
		}
		catch (Exception e) {
			return NBAMaintenanceReturn.getMaintReturnError(team, e.toString());
		}
	}

}
