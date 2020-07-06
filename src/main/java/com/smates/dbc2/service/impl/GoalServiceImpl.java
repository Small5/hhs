package com.smates.dbc2.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smates.dbc2.mapper.GoalDao;
import com.smates.dbc2.po.Goal;
import com.smates.dbc2.service.GoalService;
import com.smates.dbc2.service.UserAndLanguageService;
import com.smates.dbc2.service.UserService;
import com.smates.dbc2.utils.StringUtils;
import com.smates.dbc2.vo.Node;

@Service
public class GoalServiceImpl implements GoalService {

	@Autowired
	private GoalDao goalDao;
	@Autowired
	public UserAndLanguageService userAndLanguageService;
	@Autowired
	public UserService userService;

	@Override
	public void addGoal(String projectId, String goal_1, String goal_2, String goal_3, String index_111, String index_112,
			String index_121, String index_131, String index_132, String index_141, String index_142, String index_143,
			String index_144, String index_211, String index_221, String index_231, String index_311, String index_321,
			String index_331, String index_341, String index_351, String index_352,
			String index_361, String index_371, String index_372, String index_373, String index_381,
			String goal_1_status,String goal_2_status,String goal_3_status,String index_111_status,
			String index_112_status,String index_121_status,String index_131_status,String index_132_status,
			String index_141_status,String index_142_status,String index_143_status,String index_144_status,
			String index_211_status,String index_221_status,String index_231_status,
			String index_311_status,String index_321_status,String index_331_status,
			String index_341_status,String index_351_status,String index_352_status,
			String index_361_status,String index_371_status,String index_372_status,
			String index_373_status,String index_381_status) {
		goalDao.addGoal(new Goal(projectId, goal_1, goal_2, goal_3, index_111, index_112, index_121,
				index_131, index_132, index_141, index_142, index_143, index_144, index_211, index_221, index_231,
				index_311, index_321, index_331, index_341, index_351, index_352, index_361,
				index_371, index_372, index_373, index_381,
				goal_1_status,goal_2_status,goal_3_status,index_111_status,
				index_112_status,index_121_status,index_131_status,index_132_status,
				index_141_status,index_142_status,index_143_status,index_144_status,
				index_211_status,index_221_status,index_231_status,
				index_311_status,index_321_status,index_331_status,
				index_341_status,index_351_status,index_352_status,
				index_361_status,index_371_status,index_372_status,
				index_373_status,index_381_status));
	}

	@Override
	public Node getGoalTreeById(String id) {
		String userLanguage = userAndLanguageService.getUserAndLanuage(userService.getCurrentUserId());
		Node root = new Node();
		Node node1 = new Node();
	
		Node node11 = null;
		Node node12 = null;
		Node node13 = null;
		Node node14 = null;
		Node node21 = null;
		Node node22 = null;
		Node node23 = null;
		Node node31 = null;
		Node node32 = null;
		Node node33 = null;
		Node node34 = null;
		Node node35 = null;
		Node node36 = null;
		Node node37 = null;
		Node node38 = null;
		Goal goal = goalDao.getGoalById(id);
		System.out.println("语言："+userLanguage);
		if(userLanguage.equals("chinese")) {
			node1.setName("进行流域水资源的可持续管理" + goal.getGoal_1() + "%");
		}else {
			node1.setName("Sustainable management of water resources in the basin" + goal.getGoal_1() + "%");
		}
		
		List<Node> node1child = new ArrayList<Node>();
		
		String index_111 = goal.getIndex_111();
		String index_112 = goal.getIndex_112();
		if (!StringUtils.isEmpty(index_111) || !StringUtils.isEmpty(index_112)) {
			node11 = new Node();
			if(userLanguage.equals("chinese")) {
				node11.setName("提高水资源利用率");
			}else {
				node11.setName("Improve water use efficiency");
			}
			
			List<Node> children = new ArrayList<Node>();
			if (!StringUtils.isEmpty(index_111)) {
				if(userLanguage.equals("chinese")) {
					children.add(new Node("水生产力", null));
				}else {
					children.add(new Node("Water productivity", null));
				}
				
			}
			if (!StringUtils.isEmpty(index_112)) {
				if(userLanguage.equals("chinese")) {
					children.add(new Node("用水压力", null));
				}else {
					children.add(new Node("Water pressure", null));
				}	
			}
			node11.setChildren(children);
			node1child.add(node11);
		}
		
		String index_121 = goal.getIndex_121();
		if (!StringUtils.isEmpty(index_121)) {
			node12 = new Node();
			if(userLanguage.equals("chinese")) {
				node12.setName("人人可以公平享受负担得起的安全饮用水");
			}else {
				node12.setName("Everyone can enjoy affordable and safe drinking water at fair");
			}
			
			List<Node> children = new ArrayList<Node>();
			if(userLanguage.equals("chinese")) {
				children.add(new Node("安全饮用水人口比例", null));
			}else {
				children.add(new Node("Proportion of safe drinking water population", null));
			}
			node12.setChildren(children);
			node1child.add(node12);
		}
		
		String index_131 = goal.getIndex_131();
		String index_132 = goal.getIndex_132();
		if (!StringUtils.isEmpty(index_131) || !StringUtils.isEmpty(index_132)) {
			node13 = new Node();
			if(userLanguage.equals("chinese")) {
				node13.setName("在所有层次上实现集成水资源管理");
			}else {
				node13.setName("Integrated water management at all levels");
			}
			
			List<Node> children = new ArrayList<Node>();
			if (!StringUtils.isEmpty(index_131)) {
				if(userLanguage.equals("chinese")) {
					children.add(new Node("集成水资源管理执行度", null));
				}else {
					children.add(new Node("Integrated water resources management implementation", null));
				}
				
			}
			if (!StringUtils.isEmpty(index_132)) {
				if(userLanguage.equals("chinese")) {
					children.add(new Node("跨边界流域可操作合约有效性", null));
				}else {
					children.add(new Node("Cross-border watershed operational contract validity", null));
				}
				
			}
			node13.setChildren(children);
			node1child.add(node13);
		}
		
		String index_141 = goal.getIndex_141();
		String index_142 = goal.getIndex_142();
		String index_143 = goal.getIndex_143();
		String index_144 = goal.getIndex_144();
		if (!StringUtils.isEmpty(index_141) || !StringUtils.isEmpty(index_142) || !StringUtils.isEmpty(index_143) || !StringUtils.isEmpty(index_144)) {
			node14 = new Node();
			if(userLanguage.equals("chinese")) {
				node14.setName("保护和恢复与水相关的生态系统");
			}else {
				node14.setName("Protect and restore water-related ecosystems");
			}
			
			List<Node> children = new ArrayList<Node>();
			if (!StringUtils.isEmpty(index_141)) {
				if(userLanguage.equals("chinese")) {
					children.add(new Node("维持流域可持续湿地面积", null));
				}else {
					children.add(new Node("Maintain a sustainable wetland area in the basin", null));
				}
				
			}
			if (!StringUtils.isEmpty(index_142)) {
				if(userLanguage.equals("chinese")) {
					children.add(new Node("下游可持续生态系统发展所需最小水量", null));
				}else {
					children.add(new Node("Minimum amount of water required for downstream sustainable ecosystem development", null));
				}
				
			}
			if (!StringUtils.isEmpty(index_143)) {
				if(userLanguage.equals("chinese")) {
					children.add(new Node("中游地下水开采量", null));
				}else {
					children.add(new Node("Middle groundwater exploitation", null));
				}
				
			}
			if (!StringUtils.isEmpty(index_144)) {
				if(userLanguage.equals("chinese")) {
					children.add(new Node("中游生态系统用水量", null));
				}else {
					children.add(new Node("Midstream ecosystem water consumption", null));
				}
				
			}
			node14.setChildren(children);
			node1child.add(node14);
		}
		node1.setChildren(node1child);
		
		
		Node node2 = new Node();
		if(userLanguage.equals("chinese")) {
			node2.setName("可持续管理森林，防治荒漠化" + goal.getGoal_2() + "%");
		}else {
			node2.setName("Sustainable management of forests and combating desertification" + goal.getGoal_2() + "%");
		}
		
		List<Node> node2child = new ArrayList<Node>();
		String index_211 = goal.getIndex_211();
		if (!StringUtils.isEmpty(index_211)) {
			node21 = new Node();
			if(userLanguage.equals("chinese")) {
				node21.setName("确保保护和恢复森林生态系统");
			}else {
				node21.setName("Ensure the protection and restoration of forest ecosystems");
			}
			
			List<Node> children = new ArrayList<Node>();
			if(userLanguage.equals("chinese")) {
				children.add(new Node("森林覆盖率", null));
			}else {
				children.add(new Node("Forest cover rate", null));
			}
			
			node21.setChildren(children);
			node2child.add(node21);
		}
		String index_221 = goal.getIndex_221();
		if (!StringUtils.isEmpty(index_221)) {
			node22 = new Node();
			if(userLanguage.equals("chinese")) {
				node22.setName("与荒漠化做斗争，恢复退化的土地和土壤");
			}else {
				node22.setName("Fight desertification and restore degraded land and soil");
			}
			
			List<Node> children = new ArrayList<Node>();
			if(userLanguage.equals("chinese")) {
				children.add(new Node("退化土地占总土地面积比例", null));
			}else {
				children.add(new Node("Degraded land as a percentage of total land area", null));
			}
			
			node22.setChildren(children);
			node2child.add(node22);
		}
		String index_231 = goal.getIndex_231();
		if (!StringUtils.isEmpty(index_231)) {
			node23 = new Node();
			if(userLanguage.equals("chinese")) {
				node23.setName("确保山地生态系统的可持续发展");
			}else {
				node23.setName("Ensuring the sustainable development of mountain ecosystems");
			}
			
			List<Node> children = new ArrayList<Node>();
			if(userLanguage.equals("chinese")) {
				children.add(new Node("绿色覆盖指数", null));
			}else {
				children.add(new Node("Green coverage index", null));
			}
			
			node23.setChildren(children);
			node2child.add(node23);
		}
		node2.setChildren(node2child);
		
		
		
		Node node3 = new Node();
		if(userLanguage.equals("chinese")) {
			node3.setName("促进可持续经济增长、促进实现充分和生产性就业" + goal.getGoal_3() + "%");
		}else {
			node3.setName("Promote sustainable economic growth and promote full and productive employment" + goal.getGoal_3() + "%");
		}
		
		List<Node> node3child = new ArrayList<Node>();
		String index_311 = goal.getIndex_311();
		if (!StringUtils.isEmpty(index_311)) {
			node31 = new Node();
			if(userLanguage.equals("chinese")) {
				node31.setName("可持续与自然环境相一致的人均经济增长");
			}else {
				node31.setName("Per capita economic growth consistent with the natural environment");
			}
			
			List<Node> children = new ArrayList<Node>();
			if(userLanguage.equals("chinese")) {
				children.add(new Node("人均GDP", null));
			}else {
				children.add(new Node(" GDP per capita", null));
			}
			
			node31.setChildren(children);
			node3child.add(node31);
		}
		String index_321 = goal.getIndex_321();
		if (!StringUtils.isEmpty(index_321)) {
			node32 = new Node();
			if(userLanguage.equals("chinese")) {
				node32.setName("得到经济生产力的高水平");
			}else {
				node32.setName("Get a high level of economic productivity");
			}
			
			List<Node> children = new ArrayList<Node>();
			if(userLanguage.equals("chinese")) {
				children.add(new Node("就业人口人均 GDP 增长率 ", null));
			}else {
				children.add(new Node("Rate of growth of GDP per capita", null));
			}
			
			node32.setChildren(children);
			node3child.add(node32);
		}
		String index_331 = goal.getIndex_331();
		if (!StringUtils.isEmpty(index_331)) {
			node33 = new Node();
			if(userLanguage.equals("chinese")) {
				node33.setName("实质性降低年轻人就业率");
			}else {
				node33.setName("Substantially reduce the employment rate of young people");
			}
			
			List<Node> children = new ArrayList<Node>();
			if (!StringUtils.isEmpty(index_331)) {
				if(userLanguage.equals("chinese")) {
					children.add(new Node("年轻人（15-24）在教育，就业和培训中的比例 ", null));
				}else {
					children.add(new Node("Rate of young people accepting vocational training ", null));
				}
				
			}
			node33.setChildren(children);
			node3child.add(node33);
		}
		String index_341 = goal.getIndex_341();
		
		if (!StringUtils.isEmpty(index_341)) {
			node34 = new Node();
			if(userLanguage.equals("chinese")) {
				node34.setName("促进可持续旅游业发展，创造就业机会和提升当地文化");
			}else {
				node34.setName("Promote sustainable tourism development, create jobs and enhance local culture");
			}
			
			List<Node> children = new ArrayList<Node>();
			if (!StringUtils.isEmpty(index_341)) {
				if(userLanguage.equals("chinese")) {
					children.add(new Node("旅游业产值在 GDP中的比例 ", null));
				}else {
					children.add(new Node("Proportion of tourism output in GDP ", null));
				}
				
			}
		
			node34.setChildren(children);
			node3child.add(node34);
		}
		String index_351 = goal.getIndex_351();
		String index_352 = goal.getIndex_352();
		if (!StringUtils.isEmpty(index_351) || !StringUtils.isEmpty(index_352)) {
			node35 = new Node();
			if(userLanguage.equals("chinese")) {
				node35.setName("确保可持续城市化发展和人人参与能力");
			}else {
				node35.setName("Ensuring sustainable urbanization and participation");
			}
			
			List<Node> children = new ArrayList<Node>();
			if (!StringUtils.isEmpty(index_351)) {
				if(userLanguage.equals("chinese")) {
					children.add(new Node("土地消耗率与人口增长率的比率", null));
				}else {
					children.add(new Node("Ratio of land consumption rate to population growth rate", null));
				}
				
			}
			if (!StringUtils.isEmpty(index_352)) {
				if(userLanguage.equals("chinese")) {
					children.add(new Node("城镇化率", null));
				}else {
					children.add(new Node("Urbanization rate", null));
				}
				
			}
			node35.setChildren(children);
			node3child.add(node35);
		}
		String index_361 = goal.getIndex_361();
		if (!StringUtils.isEmpty(index_361)) {
			node36 = new Node();
			if(userLanguage.equals("chinese")) {
				node36.setName("社会福利的提高");
			}else {
				node36.setName("Improvement of social welfare");
			}
			
			List<Node> children = new ArrayList<Node>();
			if (!StringUtils.isEmpty(index_361)) {
				if(userLanguage.equals("chinese")) {
					children.add(new Node("人均社会福利", null));
				}else {
					children.add(new Node("Per capita social welfare", null));
				}
				
			}
			node36.setChildren(children);
			node3child.add(node36);
		}
		String index_371 = goal.getIndex_371();
		String index_372 = goal.getIndex_372();
		String index_373 = goal.getIndex_373();
		if (!StringUtils.isEmpty(index_371)|| !StringUtils.isEmpty(index_372) || !StringUtils.isEmpty(index_373)) {
			node37 = new Node();
			if(userLanguage.equals("chinese")) {
				node37.setName("提高农业水生产力");
			}else {
				node37.setName("Improve agricultural water productivity");
			}
			
			List<Node> children = new ArrayList<Node>();
			if(!StringUtils.isEmpty(index_371)) {
				if(userLanguage.equals("chinese")) {
					children.add(new Node("提高水农业生产力到 ", null));
				}else {
					children.add(new Node("Improve water agriculture productivity to ", null));
				}
				
			}
			if (!StringUtils.isEmpty(index_372)) {
				if(userLanguage.equals("chinese")) {
					children.add(new Node("提高农业水利用效率到 ", null));
				}else {
					children.add(new Node("Improve agricultural water use efficiency to ", null));
				}
				
			}
			if (!StringUtils.isEmpty(index_373)) {
				if(userLanguage.equals("chinese")) {
					children.add(new Node("提高每公顷农产品产值 ", null));
				}else {
					children.add(new Node("Increase the output value of agricultural products per hectare to.", null));
				}
				
			}
			node37.setChildren(children);
			node3child.add(node37);
		}
		String index_381 = goal.getIndex_381();
		if (!StringUtils.isEmpty(index_381)) {
			node38 = new Node();
			if(userLanguage.equals("chinese")) {
				node38.setName("确保可持续粮食生产");
			}else {
				node38.setName("Ensuring sustainable food production");
			}
			
			List<Node> children = new ArrayList<Node>();
			if(userLanguage.equals("chinese")) {
				children.add(new Node("维持可持续发展的中游耕地面积", null));
			}else {
				children.add(new Node("Maintaining sustainable development in the middle reaches of cultivated land", null));
			}
			
			node38.setChildren(children);
			node3child.add(node38);
		}
		node3.setChildren(node3child);
		
		List<Node> rootchildren = new ArrayList<Node>();
		rootchildren.add(node1);
		rootchildren.add(node2);
		rootchildren.add(node3);
		if(userLanguage.equals("chinese")) {
			root.setName("目标体系设定");
		}else {
			root.setName("Structure Chart of River Basin Sustainable Development Goals");
		}
		
		root.setChildren(rootchildren);
		return root;
	}

	@Override
	public void deleteGoalById(String id) {
		goalDao.deleteGoalById(id);
	}

	@Override
	public Goal getGoalById(String id) {
		return goalDao.getGoalById(id);
	}

}