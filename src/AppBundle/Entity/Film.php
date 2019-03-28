<?php

namespace AppBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Film
 *
 * @ORM\Table(name="film", indexes={@ORM\Index(name="fk_film", columns={"idEvent"})})
 * @ORM\Entity
 */
class Film
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idFilm", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idfilm;

    /**
     * @var string
     *
     * @ORM\Column(name="trailer", type="string", length=255, nullable=false)
     */
    private $trailer;

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
     * Get idfilm
     *
     * @return integer
     */
    public function getIdfilm()
    {
        return $this->idfilm;
    }

    /**
     * Set trailer
     *
     * @param string $trailer
     *
     * @return Film
     */
    public function setTrailer($trailer)
    {
        $this->trailer = $trailer;

        return $this;
    }

    /**
     * Get trailer
     *
     * @return string
     */
    public function getTrailer()
    {
        return $this->trailer;
    }

    /**
     * Set idevent
     *
     * @param \AppBundle\Entity\Evenement $idevent
     *
     * @return Film
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
