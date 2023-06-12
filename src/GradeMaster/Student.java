package GradeMaster;



    public class Student{
        private String fullName;
        private String stud_Id;
        private String subject_Id;
        private int grade;

        //Constructor
        public Student(String fullName, String stud_Id, String subject_Id, int grade){
        this.fullName= fullName;
        this.stud_Id= stud_Id;
        this.subject_Id= subject_Id;
        this.grade= grade;
        }


        //Setter methode for fullName
        public void setFullName(String fullName){
            this.fullName= fullName;
        }

        public String getFullName(){
            return fullName;
        }


        public void  setStud_Id(String stud_Id){
            this.stud_Id= stud_Id;
        }

        public String getStud_Id(){
            return stud_Id;
        }

        public void setSubject_Id(String subject_Id){
            this.subject_Id=subject_Id;
        }

        public String getSubject_Id(){
            return subject_Id;
        }

        public void setGrade(int grade){
            this.grade= grade;
        }

        public int getGrade() {
            return grade;
        }



    }



