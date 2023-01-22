package com.tongxue.footballguessing.repository;

import java.util.*;

public class MN {
	public static void main(String[] args) {

		float targert[] = {3.4F, 2.2F, 3.55F, 3.15F, 3.95F, 1.84F};
		int round = 2;
		calcuCost(targert.length, round);
		Map<Integer, List<List<Float>>> integerListMap = cmnAll(targert, round);
		for (Map.Entry<Integer, List<List<Float>>> passNum_targetSP : integerListMap.entrySet()) {
			List<Float> money = new ArrayList<>();
			Integer passNum = passNum_targetSP.getKey();
			for (List<Float> simpleList : passNum_targetSP.getValue()) {

				float v = assumptionAllPassByRound(simpleList, round);
				money.add(v);
			}
			Collections.sort(money);
			System.out.println("过 " + passNum + " 场" + "  size>>>" + money.size() + "   valList》》》" + money);


		}

	}

	/**
	 * 5场 ，两关
	 *
	 * @param goals
	 * @param round
	 */
	private static void calcuCost(int goals, int round) {

	}

	private static float assumptionAllPassByRound(List<Float> targert, int... round) {
		float all = 0;
		for (int i = 0; i < round.length; i++) {
			float v = simpleByRound(targert, round[i], 1F, 0);
			all += v;

		}
		return all * 2;
	}

	private static float simpleByRound(List<Float> target, float remainCishu, float sum, int targetIndex) {
		if (remainCishu == 0) {
			return sum;
		}
		if (targetIndex + remainCishu > target.size()) {
			return 0;
		}
		float sumAll = 0;
		for (int i = targetIndex; i < target.size(); i++) {
			double method = simpleByRound(target, remainCishu - 1, sum * target.get(i), i + 1);
			sumAll += method;
		}
		return sumAll;
	}


	/**
	 * sp array：1 2 3 4   round:2
	 * 2: 1-2 1-3 1-4  2-3 ,2-4 ,3-4
	 * 3: 1-2-3 1-3-4 2-3-4
	 * 4: 1-2-3-4
	 *
	 * @param target
	 * @param round
	 * @return
	 */
	private static Map<Integer, List<List<Float>>> cmnAll(float[] target, int round) {
		Arrays.sort(target);
		Map<Integer, List<List<Float>>> targetArrayMap = new HashMap<>();

		for (int i = round; i <= target.length; i++) {
			List<List<Float>> result = new ArrayList<>();
			cmn(result, target, i);
			targetArrayMap.put(i, result);
			if (i == round) {
				System.out.println("cost:>>>" + result.size() * 2);
			}
		}

		return targetArrayMap;
	}

	/**
	 * ?õ?[
	 * [1,2]
	 * [1,3]
	 * [1,4]
	 * ]
	 *
	 * @param result
	 * @param target
	 * @param round
	 */
	private static void cmn(List<List<Float>> result, float[] target, int round) {
		for (int startIndex = 0; startIndex < target.length; startIndex++) {
			if (startIndex + round > target.length) return;
			List<Float> culResult = new ArrayList<>();
			culResult.add(target[startIndex]);
			int cishu = round;
			cnmSimple(result, culResult, target, startIndex + 1, cishu - 1);

		}

	}

	/**
	 * ?õ? [1,2]
	 *
	 * @param culResult
	 * @param target
	 * @param startIndex
	 * @param cishu
	 */

	private static void cnmSimple(List<List<Float>> result, List<Float> culResult, float[] target, int startIndex, int cishu) {
		if (cishu == 0) {
			result.add(new ArrayList<>(culResult));
			culResult.remove(culResult.size() - 1);
			return;
		}

		for (int i = startIndex; i < target.length; i++) {
			culResult.add(target[i]);
			cnmSimple(result, culResult, target, i + 1, cishu - 1);
		}
		culResult.remove(culResult.size() - 1);
	}
}
