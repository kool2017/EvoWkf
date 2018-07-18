package com.kool.system.bean.io.counter;

import com.kool.core.base.BaseBean;
import com.kool.core.exception.AppException;
import com.kool.core.util.StringUtils;
import com.kool.core.validate.IIoValidate;

/**
 * @AUTHOR LUYU
 */
public class SYCNTINFYBean extends BaseBean implements IIoValidate {
	protected String counterCode;
	protected String name;
	protected String curValue;
	protected String min;
	protected String max;
	protected String step;
	protected String over;
	protected String resetPeriod;
	protected String resetTime;
	protected String state;

	public String getCounterCode() {
		return counterCode;
	}

	public void setCounterCode(String counterCode) {
		this.counterCode = counterCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurValue() {
		return curValue;
	}

	public void setCurValue(String curValue) {
		this.curValue = curValue;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getOver() {
		return over;
	}

	public void setOver(String over) {
		this.over = over;
	}

	public String getResetPeriod() {
		return resetPeriod;
	}

	public void setResetPeriod(String resetPeriod) {
		this.resetPeriod = resetPeriod;
	}

	public String getResetTime() {
		return resetTime;
	}

	public void setResetTime(String resetTime) {
		this.resetTime = resetTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public void validate() throws AppException {
		//非空校验
		if (StringUtils.isEmpty(counterCode)) {
			throw new AppException("SY000036","counterCode");//字段[%1]为空
		}
		//最小长度校验
		if (counterCode != null && counterCode.length()<8) {
			throw new AppException("SY000037","counterCode",String.valueOf(8));//字段[%1]小于最小长度[%2]
		}
		//最大长度校验
		if (counterCode != null && counterCode.length()>8) {
			throw new AppException("SY000038","counterCode",String.valueOf(8));//字段[%1]大于最大长度[%2]
		}
		//非空校验
		if (StringUtils.isEmpty(name)) {
			throw new AppException("SY000036","name");//字段[%1]为空
		}
		//最大长度校验
		if (name != null && name.length()>15) {
			throw new AppException("SY000038","name",String.valueOf(15));//字段[%1]大于最大长度[%2]
		}
		//非空校验
		if (StringUtils.isEmpty(curValue)) {
			throw new AppException("SY000036","curValue");//字段[%1]为空
		}
		//最大长度校验
		if (curValue != null && curValue.length()>10) {
			throw new AppException("SY000038","curValue",String.valueOf(10));//字段[%1]大于最大长度[%2]
		}
		//非空校验
		if (StringUtils.isEmpty(min)) {
			throw new AppException("SY000036","min");//字段[%1]为空
		}
		//最大长度校验
		if (min != null && min.length()>10) {
			throw new AppException("SY000038","min",String.valueOf(10));//字段[%1]大于最大长度[%2]
		}
		//非空校验
		if (StringUtils.isEmpty(max)) {
			throw new AppException("SY000036","max");//字段[%1]为空
		}
		//最大长度校验
		if (max != null && max.length()>10) {
			throw new AppException("SY000038","max",String.valueOf(10));//字段[%1]大于最大长度[%2]
		}
		//非空校验
		if (StringUtils.isEmpty(step)) {
			throw new AppException("SY000036","step");//字段[%1]为空
		}
		//最大长度校验
		if (step != null && step.length()>10) {
			throw new AppException("SY000038","step",String.valueOf(10));//字段[%1]大于最大长度[%2]
		}
		//非空校验
		if (StringUtils.isEmpty(over)) {
			throw new AppException("SY000036","over");//字段[%1]为空
		}
		//最大长度校验
		if (over != null && over.length()>1) {
			throw new AppException("SY000038","over",String.valueOf(1));//字段[%1]大于最大长度[%2]
		}
		//非空校验
		if (StringUtils.isEmpty(resetPeriod)) {
			throw new AppException("SY000036","resetPeriod");//字段[%1]为空
		}
		//最大长度校验
		if (resetPeriod != null && resetPeriod.length()>1) {
			throw new AppException("SY000038","resetPeriod",String.valueOf(1));//字段[%1]大于最大长度[%2]
		}
		//非空校验
		if (StringUtils.isEmpty(state)) {
			throw new AppException("SY000036","state");//字段[%1]为空
		}
		//最大长度校验
		if (state != null && state.length()>1) {
			throw new AppException("SY000038","state",String.valueOf(1));//字段[%1]大于最大长度[%2]
		}
	}
}