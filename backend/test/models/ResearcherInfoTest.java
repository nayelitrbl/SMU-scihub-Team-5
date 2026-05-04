package models;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class ResearcherInfoTest {
    private ResearcherInfo info;
    //@Before befroe each test to prevent mutations and start fresh
    @Before
    public void setUp() {
        info = new ResearcherInfo(
            null, //user byut we aren't using user
            "Machine Learning, NLP",  //research fields
            "PhD", //highest degeree
            "0000-0001-2345-6789",     //orcid
            "School of Computing and Information Systems", //school
            "Computer Science"  //department
        );
    }
    //each method tests a behavior (in the name of the method)
    @Test
    public void constructorSetsDepartment() {
        assertThat(info.getDepartment()).isEqualTo("Computer Science");
    }
    @Test
    public void constructorSetsSchool() {
        assertThat(info.getSchool())
            .isEqualTo("School of Computing and Information Systems");
    }
    @Test
    public void constructorSetsResearchFields() {
        assertThat(info.getResearchFields()).isEqualTo("Machine Learning, NLP");
    }
    @Test
    public void constructorSetsHighestDegree() {
        assertThat(info.getHighestDegree()).isEqualTo("PhD");
    }
    @Test
    public void constructorSetsOrcid() {
        assertThat(info.getOrcid()).isEqualTo("0000-0001-2345-6789");
    }
    @Test
    public void departmentCanBeUpdated() {
        info.setDepartment("Information Systems");
        assertThat(info.getDepartment()).isEqualTo("Information Systems");
    }
    @Test
    public void departmentCanBeSetToEmptyString() {
        info.setDepartment("");
        assertThat(info.getDepartment()).isEmpty();
    }
    @Test
    public void departmentCanBeNull() {
        info.setDepartment(null);
        assertThat(info.getDepartment()).isNull();
    }
}