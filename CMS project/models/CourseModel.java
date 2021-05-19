package models;

public class CourseModel {
    
    private String courseName;
    private String courseText;

    public CourseModel(){}

    public CourseModel(String courseName, String courseText)
    {
        this.courseName = courseName;
        this.courseText = courseText;
    }

    public CourseModel(CourseModel cmodel)
    {
        this.courseName = cmodel.courseName;
        this.courseText = cmodel.courseText;
    }

    public void SetCourseName(String courseName)
    {
        this.courseName = courseName;
    }
    public void SetCourseContent(String courseText)
    {
        this.courseText = courseText;
    }
    public String GetCourseName()
    {
        return this.courseName;
    }
    public String GetCourseText()
    {
        return this.courseText;
    }


}
