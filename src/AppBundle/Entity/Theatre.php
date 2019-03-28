<?php

namespace AppBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Theatre
 *
 * @ORM\Table(name="theatre", indexes={@ORM\Index(name="fk_theatre", columns={"idEvent"})})
 * @ORM\Entity
 */
class Theatre
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idTheatre", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idtheatre;

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
     * Get idtheatre
     *
     * @return integer
     */
    public function getIdtheatre()
    {
        return $this->idtheatre;
    }

    /**
     * Set idevent
     *
     * @param \AppBundle\Entity\Evenement $idevent
     *
     * @return Theatre
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
