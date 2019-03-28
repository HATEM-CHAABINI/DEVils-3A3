<?php

namespace AppBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Conference
 *
 * @ORM\Table(name="conference", indexes={@ORM\Index(name="fk_conf", columns={"idEvent"})})
 * @ORM\Entity
 */
class Conference
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idConference", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idconference;

    /**
     * @var \Evenement
     *
     * @ORM\ManyToOne(targetEntity="Evenement")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idEvent", referencedColumnName="idEvent")
     * })
     */
    private $idevent;



    /**
     * Get idconference
     *
     * @return integer
     */
    public function getIdconference()
    {
        return $this->idconference;
    }

    /**
     * Set idevent
     *
     * @param \AppBundle\Entity\Evenement $idevent
     *
     * @return Conference
     */
    public function setIdevent(\AppBundle\Entity\Evenement $idevent = null)
    {
        $this->idevent = $idevent;

        return $this;
    }

    /**
     * Get idevent
     *
     * @return \AppBundle\Entity\Evenement
     */
    public function getIdevent()
    {
        return $this->idevent;
    }
}
