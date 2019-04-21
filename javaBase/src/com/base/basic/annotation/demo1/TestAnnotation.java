package com.base.basic.annotation.demo1;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Retention ֻ������ Annotation���壬ָAnnotation ���Ա����೤ʱ��
//@Retention(value = RetentionPolicy.CLASS)//����java����ʱ��jvm���ܻ�ȡAnnotation��Ϣ������Ĭ��ֵ
@Retention(value = RetentionPolicy.RUNTIME)// ���д����ǣ�ͨ��������Ի�ȡAnnotation��Ϣ��
//@Retention(value = RetentionPolicy.SOURCE)// ֻ������Դ���У�����ʱֱ�Ӷ���

//@Target ֻ������ Annotation���壬��ʾ��Annotation ����������Щ��Ԫ
//@Target(value = ElementType.ANNOTATION_TYPE)// ��ʾ��Annotationֻ������ Annotation
//@Target(value = ElementType.CONSTRUCTOR)// ��ʾ��Annotationֻ������ ������
//@Target(value = ElementType.FIELD)// ��ʾ��Annotationֻ������ ��Ա����
//@Target(value = ElementType.LOCAL_VARIABLE)// ��ʾ��Annotationֻ������ �ֲ�����
//@Target(value = ElementType.METHOD)// ��ʾ��Annotationֻ������ ����
//@Target(value = ElementType.PACKAGE)// ��ʾ��Annotationֻ������ ������
//@Target(value = ElementType.PARAMETER)// ��ʾ��Annotationֻ������ ����
//@Target(value = ElementType.TYPE)// ��ʾ��Annotationֻ������ �ࡢ�ӿڣ�����ע�����ͣ���ö��
@Target({ElementType.TYPE,ElementType.METHOD})

@Documented// ��ʾ��Annotation �࣬����javadoc������ȡ���ĵ�
@Inherited// ��ʾ��Annotation�࣬���м̳���

public @interface TestAnnotation {

}



